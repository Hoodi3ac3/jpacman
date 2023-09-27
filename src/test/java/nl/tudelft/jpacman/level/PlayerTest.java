package nl.tudelft.jpacman.level;


import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    /**
     * I prefer to save the instances for this test in particular
     * because it is really a pain to instantiate Player, and I
     * will want to test other methods of Player in here.
     */
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private Player ThePlayer = Factory.createPacMan();

    @Test
    void testAlive(){
        assertThat(ThePlayer.isAlive()).isEqualTo(true);
    }

    //more tests
    @Test
    void testSetAlive() {
        ThePlayer.setAlive(false);
        assertThat(ThePlayer.isAlive()).isFalse();

        ThePlayer.setAlive(true);
        assertThat(ThePlayer.isAlive()).isTrue();
    }

    @Test
    void testGetScore() {
        assertThat(ThePlayer.getScore()).isZero();

        ThePlayer.addPoints(100);
        assertThat(ThePlayer.getScore()).isEqualTo(100);
    }

    @Test
    void testAddPoints() {
        assertThat(ThePlayer.getScore()).isZero();

        ThePlayer.addPoints(50);
        assertThat(ThePlayer.getScore()).isEqualTo(50);

        ThePlayer.addPoints(100);
        assertThat(ThePlayer.getScore()).isEqualTo(150);
    }
}

