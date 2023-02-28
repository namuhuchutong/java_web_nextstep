package chapter6.webapp.web.storoage.session;

import java.util.HashMap;
import java.util.Map;

public class HttpSession {

	private Map<String, Object> attributes;

	public HttpSession() {
		this.attributes = new HashMap<>();
	}

	public Object getAttribute(final String key) {
		validateKey(key);
		return this.attributes.get(key);
	}

	private void validateKey(final String key) {
		if (!attributes.containsKey(key)) {
			throw new IllegalArgumentException("존재하지 않는 키 값입니다.");
		}
	}

	public void setAttribute(final String key, final Object value) {
		this.attributes.put(key, value);
	}

	public void removeAttribute(final String key) {
		this.attributes.remove(key);
	}

	public void invalidate() {
		this.attributes = null;
		this.attributes = new HashMap<>();
	}
}
