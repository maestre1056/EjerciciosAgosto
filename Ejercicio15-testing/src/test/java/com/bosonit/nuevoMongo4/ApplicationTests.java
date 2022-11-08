package com.bosonit.nuevoMongo4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class ApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itShouldAddNumbers() {
		// given
		int numberOne = 22;
		int numberTwo = 10;

		// when
		int result = underTest.add(numberOne, numberTwo);

		//then
		int expected = 32;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a, int b){
			return a + b;
		}
	}
}
