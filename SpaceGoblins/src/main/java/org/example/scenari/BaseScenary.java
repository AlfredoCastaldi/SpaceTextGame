package org.example.scenari;

import java.util.Map;


public abstract class BaseScenary {

    protected String sceneName;

    protected Map<Integer, Class<? extends BaseScenary>> possibleDirections;

    public Map<Integer, Class<? extends BaseScenary>> getPossibleDirections() {

        return possibleDirections;
    }
}
