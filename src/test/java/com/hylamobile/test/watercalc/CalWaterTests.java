package com.hylamobile.test.watercalc;




import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalWaterTests {

	@Test
	public void calculateWater() {
		List<Long> inputList = new ArrayList<Long>();

		inputList.add(4L);
		inputList.add(2L);
		inputList.add(3L);
		inputList.add(6L);
		inputList.add(6L);
		inputList.add(5L);
		inputList.add(0L);
		inputList.add(3L);
		inputList.add(2L);
		inputList.add(8L);

		inputList.add(0L);
		inputList.add(15L);
		inputList.add(3L);
		inputList.add(0L);
		inputList.add(1L);
		inputList.add(2L);
		inputList.add(4L);
		inputList.add(6L);
		inputList.add(2L);
		inputList.add(5L);
		inputList.add(1L);
		inputList.add(3L);
		inputList.add(0L);
		inputList.add(1L);
		CalcWater calcWater = new CalcWater(inputList);
		assertEquals(51L, calcWater.calculateWater());

		inputList.clear();
		calcWater.setInputList(inputList);
		assertEquals(0, calcWater.calculateWater());

		calcWater.setInputList(null);
		assertEquals(0, calcWater.calculateWater());

		inputList.clear();
		inputList.add(18L);
		inputList.add(2L);
		inputList.add(3L);
		inputList.add(6L);
		inputList.add(6L);
		inputList.add(5L);
		inputList.add(0L);
		inputList.add(3L);
		inputList.add(2L);
		inputList.add(8L);

		calcWater.setInputList(inputList);
		assertEquals(37, calcWater.calculateWater());

		inputList.clear();
		inputList.add(0L);
		inputList.add(2L);
		inputList.add(3L);
		inputList.add(6L);
		inputList.add(6L);
		inputList.add(5L);
		inputList.add(0L);
		inputList.add(3L);
		inputList.add(2L);
		inputList.add(20L);

		calcWater.setInputList(inputList);
		assertEquals(14, calcWater.calculateWater());

	}

}
