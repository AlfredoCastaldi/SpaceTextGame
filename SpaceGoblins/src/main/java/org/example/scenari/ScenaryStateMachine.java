package org.example.scenari;

public class ScenaryStateMachine {


    private ScenaryStateMachine(){}

    private static final ScenaryStateMachine scenaryStateMachine = new ScenaryStateMachine();

    public static ScenaryStateMachine getInstance(){
        if (scenaryStateMachine != null){
            return scenaryStateMachine;
        } else {
            return new ScenaryStateMachine();
        }
    }

    private BaseScenary currentScenary = new Ambulatory();


    public void changeScenary(BaseScenary newScenary){
        System.out.println("cambio di scenario: " + newScenary.sceneName);
        this.currentScenary = newScenary;
    }
    public BaseScenary getCurrentScenary(){
        return this.currentScenary;
    }
}
