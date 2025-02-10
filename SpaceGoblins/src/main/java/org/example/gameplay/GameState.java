package org.example.gameplay;

import org.example.player.Player;
import org.example.player.AstralBerserker;
import org.example.player.SpaceMagician;
import org.example.player.StormTrooper;
import org.example.scenari.ScenaryStateMachine;

import java.time.*;

import java.util.Map;

public class GameState {

    LocalDateTime startingTime;
    LocalDateTime finishingTime;

    private static final InputManager inputManager = InputManager.getInstance();
    private static final ScenaryStateMachine scenaryStateMachine = ScenaryStateMachine.getInstance();
    private static Player userCharacterInstance;

    // una collection delle disponibili classi java da instanziare come ruolo per il giocatore

    public static Player getUserCharacterInstance() {
        return userCharacterInstance;
    }

    Map<Integer, Class<? extends Player>> classiDisponibili = Map.of(
            1, AstralBerserker.class,
            2, SpaceMagician.class,
            3, StormTrooper.class
    );

    private enum AvaibleClasses {
        ASTRAL_BERSERKER(1, "Astral berserker"),
        SPACE_MAGICIAN(2, "Space magician"),
        STORM_TROOPER(3, "Storm trooper");

        private String className;
        private int keyForMap;

        private AvaibleClasses(int keyForMap, String className) {
            this.keyForMap = keyForMap;
            this.className = className;
        }
    }


    // il codice che permette al giocatore di scegliere nome età e la classe da instanziare che diventerà il suo ruolo

    public void choseClass() {

        AvaibleClasses chosedClass = getPlayerClass();
        String chosedName = getPlayerName();
        Integer chosedAge = getPlayerAge();

        switch (chosedClass){
            case ASTRAL_BERSERKER -> userCharacterInstance = new AstralBerserker(chosedName, chosedAge);
            case SPACE_MAGICIAN -> userCharacterInstance = new SpaceMagician(chosedName, chosedAge);
            case STORM_TROOPER -> userCharacterInstance = new StormTrooper(chosedName, chosedAge);
        }
        System.out.println("player: " + userCharacterInstance);
        while (true) {
        userCharacterInstance.getDefaultActions().get(1).run();
        }

    }

    private AvaibleClasses getPlayerClass() {
        System.out.println("chose your class: ");
        for (AvaibleClasses element : AvaibleClasses.values()) {
            System.out.println(element.keyForMap + " : " + element.className);
        }
        Integer playerChoice;
        while (true) {
            playerChoice = inputManager.inputLoopForInteger();
            if (playerChoice > 0 && playerChoice <= AvaibleClasses.values().length) {
                return AvaibleClasses.values()[playerChoice - 1];
            } else {
                System.out.println("insert a valid number please ");
            }
        }
    }

    private String getPlayerName() {
        System.out.println("chose your name: ");
        return inputManager.userInputWithNoNums();
    }

    private Integer getPlayerAge() {
        System.out.println("chose your age: ");
        return inputManager.inputLoopForInteger();
    }


    public void gameInit() {

        startingTime = LocalDateTime.now();
        System.out.println(" Healbot: bzzz... ah... you finally awake... bzzz... \n" +
                " [downloading.language.ita........terminated], hey bzzz... sei sveglio finalmente!... \n" +
                " le tue funzioni vitali sembrano stabili, benvenuto sulla stazione Epsilon 9, l'ultimo baluardo per il progetto benesis \n" +
                " ( fasci verdi dall'unico occhio della macchina attraversano il tuo corpo più e più volte ) bzzz... [scanning...] \n" +
                " oh.. bzzz... non riesco a determinare la tua mansione... prego inserire manualmente la mansione assegnata");
    }

    public void gameContext() {
        System.out.println("Healbot: bene, benvenuto a bordo " + userCharacterInstance.getNome() + " sei stato risvegliato dopo l'incidente vicino ai laboratori" +
                " dove delle scimmie assassine hanno preso il controllo della nave, la tua missione attuale è di ristabilire l'ordine prendendole a pugni" +
                " buona fortuna");
    }


}
