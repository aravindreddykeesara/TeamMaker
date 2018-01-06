package com.mobileapps.ark.teammaker;

import java.io.Serializable;

/**
 * Created by ArK on 1/5/2018.
 */

public class PlayerObject implements Serializable {
    int PlayerNumber;
    String showStatus;

    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        return "PlayerObject{" +
                "PlayerNumber=" + PlayerNumber +
                ", showStatus='" + showStatus + '\'' +
                '}';
    }
}
