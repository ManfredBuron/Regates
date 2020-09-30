package regates.mvp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Boat {

    private float degree;
    private float speed;


    public int move(){
        return 0;
    }

    public boolean isCollision(Coordinate a, Coordinate b){
        return true;
    }

}