/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTests {

	Calculator calculator;
	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("empty = 0")
	void shouldReturn0WhenEmpty() {
		assertEquals(calculator.add(""), 0);
	}

	@ParameterizedTest
	@ValueSource(strings = { "1", "2", "3" })
	void shouldReturnN(String value) {
		assertThat(calculator.add(value)).isEqualTo(Integer.parseInt(value));
	}

	@Test
	@DisplayName("1+1=2")
	void shouldReturnSumValueWhenSeparatedByComa() {
		assertThat(calculator.add("1,1")).isEqualTo(2);
	}

	@Test
	@DisplayName("1+1+1+2=5")
	void shouldReturnSu() {
		assertThat(calculator.add("1,1,1,2")).isEqualTo(5);
	}

	@Test
	@DisplayName("1+1+1+2=5")
	void shouldReturnSdu() {
		assertThat(calculator.add("1,1,1,2")).isEqualTo(5);
	}

	@ParameterizedTest
	@ValueSource(strings = { "1\n1,1,2", "1\n1,1\n2", "1\n1\n1,2" })
	void shouldReturnSuh() {
		assertThat(calculator.add("1\n1,1,2")).isEqualTo(5);
	}

	@Test
	void should() {
		assertThat(calculator.add("//,\n1,2,3,5")).isEqualTo(3);
	}
}
