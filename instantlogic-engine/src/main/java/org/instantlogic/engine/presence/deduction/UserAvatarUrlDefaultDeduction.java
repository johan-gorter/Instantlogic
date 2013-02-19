package org.instantlogic.engine.presence.deduction;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.instantlogic.engine.presence.User;
import org.instantlogic.engine.presence.entity.UserEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

class MD5Util {
  public static String hex(byte[] array) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
	  sb.append(Integer.toHexString((array[i]
	      & 0xFF) | 0x100).substring(1,3));        
      }
      return sb.toString();
  }
  public static String md5Hex (String message) {
      try {
	  MessageDigest md = 
	      MessageDigest.getInstance("MD5");
	  return hex (md.digest(message.getBytes("CP1252")));
      } catch (NoSuchAlgorithmException e) {
      } catch (UnsupportedEncodingException e) {
      }
      return null;
  }
}

public class UserAvatarUrlDefaultDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		User user = context.getSelectedInstance(UserEntity.INSTANCE);
		String email = user.getEmail();
		if (email==null) return ValueAndLevel.inconclusive();
		String hash = MD5Util.md5Hex(email.toLowerCase());
		String url = "http://www.gravatar.com/avatar/"+hash+"?s=50&d=mm";
		return ValueAndLevel.def(url);
	}

}
