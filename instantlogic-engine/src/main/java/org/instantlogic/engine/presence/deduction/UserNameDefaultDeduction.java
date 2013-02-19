package org.instantlogic.engine.presence.deduction;

import org.instantlogic.engine.presence.User;
import org.instantlogic.engine.presence.entity.UserEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class UserNameDefaultDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		User user = context.getSelectedInstance(UserEntity.INSTANCE);
		String username = user.getUsername();
		if (username==null) return ValueAndLevel.inconclusive();
		int indexOfAt = username.indexOf('@'); 
		if (indexOfAt>0) {
			return ValueAndLevel.def(user.getUsername().substring(0, indexOfAt));
		}
		return ValueAndLevel.def(username);
	}

}
