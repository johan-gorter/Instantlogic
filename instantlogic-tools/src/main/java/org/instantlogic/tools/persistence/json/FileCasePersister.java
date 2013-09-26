package org.instantlogic.tools.persistence.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.AbstractTransactionListener;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.TransactionListener;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.PersistenceStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileCasePersister extends CasePersister implements PersistenceStrategy {

	private static final Logger logger = LoggerFactory.getLogger(FileCasePersister.class);

	private File casesDir;

	public FileCasePersister() {
		init();
	}

	protected void init() {
		casesDir = new File("cases");
		casesDir.mkdirs();
	}
	
	protected File getCaseDir(Application application, String caseId) {
		return casesDir;
	}

	public void persist(String id, Instance caseInstance, int version, Application application, List<ValueChangeEvent> events) {
		try {
			caseInstance.getMetadata().getCaseAdministration().setVersion(version);
			File file = new File(getCaseDir(application, id), id + ".tmp");
			FileOutputStream stream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(stream, "UTF-8");
			save(caseInstance, writer);
			writer.close();
			File targetFile = new File(getCaseDir(application, id), id + ".json");
			if (targetFile.exists()) {
				targetFile.delete();
			}
			file.renameTo(targetFile);
			logger.info("Persisted "+id+" version "+version);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public <T extends Instance> T load(String id, Class<T> ofType, Application application) {
		T result = null;
		try {
			File file = new File(getCaseDir(application, id), id + ".json");
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
			result = load(ofType, reader);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private static final Random random = new Random();

	public String uniqueId() {
		byte[] bytes = new byte[8];
		random.nextBytes(bytes);
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<bytes.length;i++) {
			sb.append(Integer.toHexString(bytes[i]/16));
			sb.append(Integer.toHexString(bytes[i]%16));
		}
		return sb.toString();
	}

	public Instance loadOrCreate(final String caseId, Class<? extends Instance> ofType, final Application application) {
		File file = new File(getCaseDir(application, caseId), caseId + ".json");
		Instance result;
		if (file.exists()) {
			result = load(caseId, ofType, application);
		} else {
			try {
				result = ofType.newInstance();
				persist(caseId, result, 1, application, null);
				return result;
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		final Instance finalResult = result;
		TransactionListener transactionListener = new AbstractTransactionListener() {
			@Override
			public void transactionCommitting(CaseAdministration instanceAdministration, List<ValueChangeEvent> events) {
				long version = finalResult.getMetadata().getCaseAdministration().getVersion();
				finalResult.getMetadata().getCaseAdministration().setVersion(version+1);
				persist(caseId, finalResult, 0, application, events);
			}
		};
		result.getMetadata().getCaseAdministration().addTransactionListener(transactionListener);
		return result;
	}
}
