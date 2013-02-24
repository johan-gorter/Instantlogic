package org.instantlogic.fabric.util.id;

import java.security.SecureRandom;

/**
 * 128 bit identifier.
 * 
 * An Id can be generated in one of the following ways:
 * - Secure random, using the same algorithm as a UUID/GUID level 4
 * - Developer friendly unique identifier: Uses a provided label, fixed random number and a global sequence number
 * - Sequence: Uses only a global sequence number
 * - Sequence per label: Uses the provided label and a sequence number.
 * - Fixed: Uses only the provided label
 * 
 * Encodes and decodes to String as follows:
 * 16 5-bit characters (label) + underscore + 8 hex digits (random) + underscore + 4 hex digits (sequence number)
 * 
 * About the String presentation:
 * - The first character is encoded from: _ABCDEFGHIJKLMNOPQRSTUVWXYZvwxyz
 * - The following characters are encoded from: _abcdefghijklmnopqrstuvwxyzVWXYZ
 * - Trailing underscores in the label are trimmed off (Except when toFixedString is used)
 * - When a hex block consists of only zeroes, it is omitted (Except when toFixedString is used)
 */
public class Id  implements java.io.Serializable, Comparable<Id> {

	private static final char[] LabelStartChars = "_ABCDEFGHIJKLMNOPQRSTUVWXYZvwxyz".toCharArray();
	private static final char[] LabelChars = "_abcdefghijklmnopqrstuvwxyzVWXYZ".toCharArray();
	private static final char[] hexChars = "0123456789abcdef".toCharArray();
	private static final String underscores = "________________";
	
    private static final long serialVersionUID = 1L;

    private final long hiBits;
	private final long loBits;

    public long getHiBits() {
		return hiBits;
	}

	public long getLoBits() {
		return loBits;
	}

    /*
     * Lazy initialized to create random GUID/UUIDs
     */
    private static class SecureRandomHolder {
        static final SecureRandom secureRandom = new SecureRandom();
    }
    
    private static char[] getLabelChars(String label)
    {
        StringBuilder chars = new StringBuilder(label.length());
    	label = label.toLowerCase();
    	boolean first = true;
        for (int i=0;i<label.length();i++) {
        	char c = label.charAt(i);
        	if (c=='_' || (c>='a' && c<='z')) {
        		if (first) {
        			first = false;
        			chars.append((char)(c+'A'-'a'));
        		} else {
        			chars.append(c);
        		}
        	}
        }
        int length = chars.length();
        if (length > 16)
        {
            int tooMuch = length - 16;
            int index = length - 1;
            while (index >= 1 && tooMuch > 0)
            {
                if ("aeiou".indexOf(chars.charAt(index))>=0)
                {
                    chars.deleteCharAt(index);
                    tooMuch--;
                }
                index--;
            }
            if (tooMuch>0) {
            	index = chars.length()-1;
                while (index >= 1 && tooMuch > 0)
                {
                    if ("hmnv".indexOf(chars.charAt(index))>=0)
                    {
                        chars.deleteCharAt(index);
                        tooMuch--;
                    }
                    index--;
                }
            }
            if (tooMuch > 0)
            {
                chars.replace(10, 11 + tooMuch,"_");
            }
        }
        else if (length < 16)
        {
            chars.append(underscores.substring(length));
        }
        char[] result = new char[16];
        chars.getChars(0, 16, result, 0);
        return result;
    }

    public static Id newFixedId(String label) {
    	char[] chars = getLabelChars(label);
		long hi = indexOf(LabelStartChars, chars[0]);
    	for (int i=1;i<12;i++) {
    		hi = (hi << 5) | indexOf(LabelChars, chars[i]);
    	}
    	long index = indexOf(LabelChars, chars[12]);
    	hi = hi << 4 | (index >> 1);
    	long lo = index << 63;
    	index = indexOf(LabelChars, chars[13]);
    	lo = lo | (index << 58);
    	index = indexOf(LabelChars, chars[14]);
    	lo = lo | (index << 53);
    	index = indexOf(LabelChars, chars[15]);
    	lo = lo | (index << 48);
    	return new Id(hi, lo);
    }
    
    /**
     * Static factory to retrieve a type 4 (pseudo randomly generated) UUID.
     *
     * The {@code Id} is generated using a cryptographically strong pseudo
     * random number generator.
     *
     * @return  A randomly generated {@code Id}, created in exactly the same way as a UUID.
     */
    public static Id newRandomId() {
        byte[] randomBytes = new byte[16];
        SecureRandomHolder.secureRandom.nextBytes(randomBytes);
        randomBytes[6]  &= 0x0f;  /* clear version        */
        randomBytes[6]  |= 0x40;  /* set to version 4     */
        randomBytes[8]  &= 0x3f;  /* clear variant        */
        randomBytes[8]  |= 0x80;  /* set to IETF variant  */
        return new Id(randomBytes);
    }
    
    private Id(byte[] data) {
        long hi = 0;
        long lo = 0;
        if(data.length != 16) throw new IllegalArgumentException("data must be 16 bytes in length");
        for (int i=0; i<8; i++) {
            hi = (hi << 8) | (data[i] & 0xff);
        }
        for (int i=8; i<16; i++) {
            lo = (lo << 8) | (data[i] & 0xff);
        }
        this.hiBits = hi;
        this.loBits = lo;
    }

    public Id(long hiBits, long loBits) {
        this.hiBits = hiBits;
        this.loBits = loBits;
    }
    
    private static long indexOf(char[] chars, char c) {
    	for (int i=0;i<chars.length;i++) {
    		if (chars[i]==c) return i;
    	}
    	throw new IllegalArgumentException("Illegal character "+c);
    }

    public static Id parse(String uidString) {
    	long hi, lo;
    	// SequenceNr
    	int lastUnderscoreIndex = uidString.lastIndexOf('_');
    	if (lastUnderscoreIndex<0) throw new IllegalArgumentException("Invalid Uid string: "+uidString);
    	String sequenceNrString = uidString.substring(lastUnderscoreIndex+1);
    	uidString = uidString.substring(0, lastUnderscoreIndex);
    	lo = Integer.parseInt(sequenceNrString);
    	// RunId
    	lastUnderscoreIndex = uidString.lastIndexOf('_');
    	if (lastUnderscoreIndex<0) throw new IllegalArgumentException("Invalid Uid string: "+uidString);
    	String runIdString = uidString.substring(lastUnderscoreIndex+1);
    	uidString = uidString.substring(0, lastUnderscoreIndex);
    	if (runIdString.length()!=0) {
    		if (runIdString.length()!=6) throw new IllegalArgumentException("Invalid Uid string: "+uidString);
    		lo = lo | (Integer.parseInt(runIdString, 16) << 24);
    	}
        // Label
    	if (uidString.length()>16) throw new IllegalArgumentException("Invalid Uid string: "+uidString);
    	while (uidString.length()<16) uidString += '_';
		char c = uidString.charAt(0);
		hi = indexOf(LabelStartChars, c);
    	for (int i=1;i<12;i++) {
    		c = uidString.charAt(i);
    		hi = (hi << 5) | indexOf(LabelChars, c);
    	}
    	c = uidString.charAt(12);
    	long index = indexOf(LabelChars, c);
    	hi = hi << 4 | (index >> 1);
    	lo = lo | (index << 63);
		c = uidString.charAt(13);
    	index = indexOf(LabelChars, c);
    	lo = lo | (index << 58);
		c = uidString.charAt(14);
    	index = indexOf(LabelChars, c);
    	lo = lo | (index << 53);
		c = uidString.charAt(15);
    	index = indexOf(LabelChars, c);
    	lo = lo | (index << 48);
        return new Id(hi, lo);
    }

    public String toString() {
    	char[] chars = new char[16];
    	chars[0] = LabelStartChars[(int)((this.hiBits >> 59) & 0x0000001f)];
    	for (int i=1;i<11;i++) {
    		chars[i] = LabelChars[(int)((this.hiBits >> (59-i*5)) & 0x0000001f)];
    	}
    	long bits = (loBits>>>48) | (hiBits<<16);
    	for (int i=11;i<16;i++) {
    		chars[i] = LabelChars[(int)((bits >> (20-(i-11)*5)) & 0x0000001f)];
    	}
    	int labelLength = 16;
    	while (chars[labelLength-1]=='_') labelLength--;
    	long sequenceNr = loBits & 0x0000ffff;
    	long runId = (loBits >> 24) & 0x00ffffff;
    	StringBuffer sb = new StringBuffer();
    	long labelBits = loBits >> 48; // 16
    	sb.insert(0, LabelChars[(int)(labelBits & 31)]);
    	labelBits = labelBits >> 5;
    	sb.insert(0, LabelChars[(int)(labelBits & 31)]);
    	labelBits = labelBits >> 5;
    	sb.insert(0, LabelChars[(int)(labelBits & 31)]);
    	labelBits = labelBits >> 5;
    	sb.insert(0, LabelChars[(int)(labelBits & 31)]);
    	labelBits = labelBits >> 5;
    	return new String(chars,0,labelLength)+"_"+hexRunId((int)runId)+"_"+hexSequenceNr((int)sequenceNr);
    }

    private String hexRunId(int runId) {
    	if (runId==0) return "";
		char[] chars = new char[6];
		for (int i=0;i<6;i++) {
			chars[5-i] = hexChars[runId & 15];
		}
		return new String(chars);
	}

    private String hexSequenceNr(int sequenceNr) {
    	if (sequenceNr==0) return "";
		char[] chars = new char[4];
		for (int i=0;i<4;i++) {
			chars[3-i] = hexChars[sequenceNr & 15];
			sequenceNr = sequenceNr >> 4;
		}
		return new String(chars);
	}

    /**
     * Returns a hash code for this {@code UUID}.
     *
     * @return  A hash code value for this {@code UUID}
     */
    public int hashCode() {
        long bits = hiBits ^ loBits;
        return ((int)(bits >> 32)) ^ (int) bits;
    }

    /**
     * Compares this object to the specified object.  The result is {@code
     * true} if and only if the argument is not {@code null}, is a {@code UUID}
     * object, has the same variant, and contains the same value, bit for bit,
     * as this {@code UUID}.
     *
     * @param  obj
     *         The object to be compared
     *
     * @return  {@code true} if the objects are the same; {@code false}
     *          otherwise
     */
    public boolean equals(Object obj) {
        if ((null == obj) || (obj.getClass() != Id.class))
            return false;
        Id id = (Id)obj;
        return (hiBits == id.hiBits &&
                loBits == id.loBits);
    }

    // Comparison Operations

    /**
     * Compares this Uid with the specified Uid.
     *
     * The first of two Uids is greater than the second if the most
     * significant field in which the Uids differ is greater for the first
     * Uid.
     *
     * @return  -1, 0 or 1 as this {@code Uid} is less than, equal to, or
     *          greater than {@code val}
     *
     */
    public int compareTo(Id val) {
        // The ordering is intentionally set up so that the UUIDs
        // can simply be numerically compared as two numbers
        return (this.hiBits < val.hiBits ? -1 :
                (this.hiBits > val.hiBits ? 1 :
                 (this.loBits < val.loBits ? -1 :
                  (this.loBits > val.loBits ? 1 :
                   0))));
    }
}
