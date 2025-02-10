package org.example.scenari;

import java.util.Map;
@SceneAnnotation(sceneName = "Ambulatory")
public class Ambulatory extends BaseScenary {


    public Ambulatory(){
        super.possibleDirections = Map.of(1, Laboratory.class);
        super.sceneName = "Ambulatory";
    }
}
