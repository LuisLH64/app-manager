package com.app_manager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

    private static final String USERNAME_REGEX = "[A-Za-z0-9_]+";
	private static final String EMAIL_REGEX = "^(.+)@(.+)$";
	private static final String NUMBER_LETTERS_ONLY = "[a-zA-Z0-9_]*";
	private static final String NAME_ACCENT_REGEX = "[0-9A-Za-zÀ-ÿ '\\-.]*";
	private static final String NUMBERS_ONLY = "[0-9]*";
	private static final String URL_REGEX = "(.)*.(com)+(.)*";
	private static final String URL_REGEX_ALT = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]"
			+ "*[-a-zA-Z0-9+&@#/%=~_|]";
	private static final String NOT_ALLOWED_REGEX = "[^À-ÿ'\"]*";
	
	public static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);
	public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	public static final Pattern NUMBER_LETTERS_PATTERN = Pattern.compile(NUMBER_LETTERS_ONLY);
	public static final Pattern NAME_ACCENT_PATTERN = Pattern.compile(NAME_ACCENT_REGEX);
	public static final Pattern NUMBERS_PATTERN = Pattern.compile(NUMBERS_ONLY);
	public static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	public static final Pattern URL_PATTERN_ALT = Pattern.compile(URL_REGEX_ALT);
    public static final Pattern NOT_ALLOWED_CHARS = Pattern.compile(NOT_ALLOWED_REGEX);
    
    private StringUtils(){}

    public static boolean isNullOrBlank(String s) {

        return s.isBlank() || s.isEmpty() || s == null;
    }
    
    public static String getEmptyIfNull(String s) {

        return isNullOrBlank(s) ? "" : s;
    }

    public static boolean isPatternValid(String s, Pattern pattern){
		Matcher m = pattern.matcher(s);
		return m.matches();
	}

    public static String removeSpecialChars(String s) {
		if (isNullOrBlank(s))
			return "";
		
		return s.replaceAll("[^a-zA-Z0-9 ]*", "");
	}
	
	public static String removeNonNumbers(String s) {
		if (isNullOrBlank(s))
			return "";
		
		return s.replaceAll("[^0-9]", "");
	}
	

    public static boolean isEmail(String s) {
        if (isNullOrBlank(s)) 
            return false;

        return isPatternValid(s, EMAIL_PATTERN);
    }

    public static boolean hasSpecialChars(String s) {
		if (isNullOrBlank(s))
			return false;
		
		return !isPatternValid(s, NUMBER_LETTERS_PATTERN);
	}
}
