package log.parser.service;

import java.util.regex.Matcher;

public interface LineParser<T> {
	 public T parse(Matcher obj);
}
