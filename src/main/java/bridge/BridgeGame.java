package bridge;

/*
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 * InputView, OutputView 를 사용하지 않는다.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> userMoving;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.userMoving = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (moving.equals(bridge.get(userMoving.size()))) {
            userMoving.add(moving);
            return true;
        }

        if(moving.equals("U")) {
            userMoving.add("UX");
        }

        if(moving.equals("D")){
            userMoving.add("DX");
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return gameCommand.equals("R");
    }

    public void resetUserMoving(){
        this.userMoving.clear();
    }

    public boolean isEndOfBridge(){
        return bridge.size() == userMoving.size();
    }

    public boolean isSuccess(){
        return isEndOfBridge() && (userMoving.get(userMoving.size()-1).equals("U") || userMoving.get(userMoving.size()-1).equals("D"));
    }

    public List<String> getUserMoving() {
        return userMoving;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
