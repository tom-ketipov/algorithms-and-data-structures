package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Comparator;

public class MiceAndFox {

    public static class Mouse {
        private final int id;
        private int position;

        public Mouse(int id, int position) {
            Validate.isTrue(id >= 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

            this.id = id;
            this.position = position;
        }

        public int getId() {
            return id;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }


    /**
     * Aligns each mouse with a corresponding hole position and updates the mouse's position accordingly.
     * <p>
     * Note: This method assumes that each mouse corresponds to one hole and vice versa; therefore, the number of
     * mice must equal the number of holes. It throws NullPointerException if any mouse within the array is null.
     *
     * @param holePositions An array of integers representing the positions of the holes where the mice will be hidden.
     * @param mice          An array of Mouse objects representing the mice to be hidden.      * @throws IllegalArgumentException If 'holePositions' or 'mice' is null, or if the lengths of 'holePositions' and 'mice' are not equal.
     * @throws NullPointerException If any Mouse object within the 'mice' array is null.
     */
    public void hide(int[] holePositions, Mouse[] mice) {
        Validate.notNull(holePositions, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(mice, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(mice.length == holePositions.length);

        Arrays.sort(holePositions);
        Arrays.sort(mice, Comparator.comparing(mouse -> mouse.position));

        for (int i = 0; i < mice.length; i++) {
            mice[i].setPosition(holePositions[i]);
        }
    }
}
