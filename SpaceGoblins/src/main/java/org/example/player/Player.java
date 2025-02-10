package org.example.player;

import org.example.gameplay.GameState;
import org.example.gameplay.InputManager;
import org.example.scenari.BaseScenary;
import org.example.scenari.ScenaryStateMachine;
import org.example.scenari.SceneAnnotation;
import org.example.utilities.MapUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public abstract class Player {


    private int vita;
    private String nome;
    private int anni;
    protected String className;

    private Map<Integer, Runnable> defaultActions = Map.of(
            1, this::movePLayer,
            2, this::exploreAround,
            3, this::talkTo,
            4, this::useItem
    );


    public Player(int vita, String nome, Integer anni) {
        this.vita = vita;
        this.nome = nome;
        this.anni = anni;
    }

    public void movePLayer() {
        Class<? extends BaseScenary> choice = playerPossibleDirections();
        try {
           ScenaryStateMachine.getInstance().changeScenary(choice.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Class<? extends BaseScenary> playerPossibleDirections() {
        System.out.println("possible directions: ");
        Map<Integer, Class<? extends BaseScenary>> possibleDirections = ScenaryStateMachine.getInstance().getCurrentScenary().getPossibleDirections();
        MapUtils.printMapForPlayer(possibleDirections, element -> element.getAnnotation(SceneAnnotation.class).sceneName());
        Integer playerChoice;
        while (true) {
            playerChoice = InputManager.getInstance().inputLoopForInteger();
            if (possibleDirections.containsKey(playerChoice))
                return possibleDirections.get(playerChoice);
            else {
                System.out.println("please enter a valid choice");
            }
        }
    }

    private void exploreAround() {
    }

    private void talkTo() {
    }

    private void useItem() {
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " vita=" + vita +
                ", nome='" + nome + '\'' +
                ", anni=" + anni;
    }

    public Map<Integer, Runnable> getDefaultActions() {
        return defaultActions;
    }

    public String getClassName() {
        return className;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }

}
