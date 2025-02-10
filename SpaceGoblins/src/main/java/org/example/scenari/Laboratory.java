package org.example.scenari;

import java.util.Map;
@SceneAnnotation(sceneName = "Laboratory")
public class Laboratory extends BaseScenary{

    public Laboratory(){
        super.possibleDirections = Map.of(1, Ambulatory.class);
        super.sceneName = "Laboratory";
    }
}
