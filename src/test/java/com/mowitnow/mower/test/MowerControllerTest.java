package com.mowitnow.mower.test;

import com.mowitnow.mower.MowerController;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerControllerTest {

    @Test
    public void testMowerMovements() {
        String lawnInfo = "5 5";
        List<String> instructions = Arrays.asList(
                "1 2 N", "GAGAGAGAA",
                "3 3 E", "AADAADADDA"
        );

        List<String> expectedPositions = Arrays.asList(
                "1 3 N",
                "5 1 E"
        );

        List<String> actualPositions = MowerController.processInstructions(lawnInfo, instructions);

        assertThat(actualPositions)
                .as("Check final positions of the mowers")
                .containsExactlyElementsOf(expectedPositions);
    }
}
