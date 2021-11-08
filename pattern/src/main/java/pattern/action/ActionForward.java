package pattern.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionForward {
	// 이동경로와 이동방식 저장
	private String path;
	private boolean redirect; // true(sendRedirect), false(forward)
	
}
