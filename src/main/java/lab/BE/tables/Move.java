package lab.BE.tables;

import org.json.JSONObject;

public class Move {
    private int id_move;
    private Animal animal;
    private JSONObject moveData;

    public Move(int id_move, Animal animal, JSONObject moveData) {
        this.id_move = id_move;
        this.animal = animal;
        this.moveData = moveData;
    }
}
