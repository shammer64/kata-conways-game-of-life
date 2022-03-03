package com.shammer.coaching.conway;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {

    @Test
    public void can_seed_with_rectangular_grid() {
        Character[][] seed =  {
                {' ',' ',' '},
                {' ','X','X'},
                {' ','X','X'}
        };
        GameOfLife cgol = new GameOfLife(seed);

        assertThat(cgol.toString()).isEqualTo("   \n XX\n XX");
    }

    @ParameterizedTest
    @CsvSource({"0,0,1", "0,1,2", "0,2,2",
        "1,0,2", "1,1,3", "1,2,3",
        "2,0,2", "2,1,3", "2,2,3"})
    public void can_get_count_of_live_neighbors(int row, int col, int expectedNeighbors) {
        Character[][] seed =  {
                {' ',' ',' '},
                {' ','X','X'},
                {' ','X','X'}
        };
        GameOfLife cgol = new GameOfLife(seed);

        assertThat(cgol.neighbors(row,col)).isEqualTo(expectedNeighbors);
    }

    @Test
    public void live_cell_with_fewer_than_two_live_neighbors_dies() {
        Character[][] seed =  {
                {' ',' ',' '},
                {' ','X',' '},
                {' ',' ','X'},
        };
        GameOfLife cgol = new GameOfLife(seed);
        cgol.evolve();

        assertThat(cgol.toString()).isEqualTo("   \n   \n   ");
    }

    @Test
    public void dead_cell_with_exactly_three_live_neighbors_reborn() {
        Character[][] seed =  {
                {' ','X',' '},
                {'X','X','X'},
                {' ','X',' '},
        };
        GameOfLife cgol = new GameOfLife(seed);
        cgol.evolve();

        assertThat(cgol.toString()).isEqualTo("XXX\nX X\nXXX");
    }

    @Test
    public void can_get_grid_dimensions() {
        Character[][] seed =  {
                {' ','X',' '},
                {'X','X','X'},
                {' ','X',' '},
        };
        GameOfLife cgol = new GameOfLife(seed);

        assertThat(cgol.width()).isEqualTo(3);
        assertThat(cgol.height()).isEqualTo(3);
    }

    @Test
    public void can_get_current_grid() {
        Character[][] seed =  {
                {' ','X',' '},
                {'X','X','X'},
                {' ','X',' '},
        };
        GameOfLife cgol = new GameOfLife(seed);

        assertThat(cgol.currentGrid()).isDeepEqualTo(seed);
    }

}
