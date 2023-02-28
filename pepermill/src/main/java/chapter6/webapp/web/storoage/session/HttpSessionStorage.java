package chapter6.webapp.web.storoage.session;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 세션 id - httpSession - 세션 객체 형태로 저장하는 클래스.
 * 세션 id는 여러개의 세션 요소를 저장할 수 있다.
 * 세션 요소는 HttpSession 객체가 관리한다.
 */
public class HttpSessionStorage {

	private static final Map<String, HttpSession> sessionStorage = new ConcurrentHashMap<>();

	public String getId() {
		return createUUID();
	}

	private String createUUID() {
		return UUID.randomUUID().toString();
	}

	public HttpSession getSession(final String uuid) {
		return sessionStorage.get(uuid);
	}

	public void createSession(final String uuid) {
		sessionStorage.put(validateUUID(uuid), new HttpSession());
	}

	private String validateUUID(final String uuid) {
		if (uuid.isEmpty() || uuid.isBlank()) {
			return getId();
		}
		return uuid;
	}
}
