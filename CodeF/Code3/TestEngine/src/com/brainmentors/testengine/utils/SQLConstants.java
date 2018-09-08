package com.brainmentors.testengine.utils;

public interface SQLConstants {
	String LOGIN_SQL = "select userid,password from users where userid=? and password=?";
}
