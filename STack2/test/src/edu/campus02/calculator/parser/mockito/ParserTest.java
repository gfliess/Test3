package edu.campus02.calculator.parser.mockito;

import java.io.File;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import edu.campus02.calculator.Calculator;
import edu.campus02.calculator.Calculator.Operation;
import edu.campus02.calculator.parser.Parser;

public class ParserTest {

	@Test
	public void validCalculation01() throws Exception {

		Calculator calcMock = mock(Calculator.class);
		when(calcMock.perform(Operation.add)).thenReturn(3.0);
		
		Parser p = new Parser(calcMock);
		double result = p.parse(new File("test/resources/test01.xml"));
		assertEquals(3.0, result, 0);

		verify(calcMock).push(1);
		verify(calcMock).push(2);
		verify(calcMock).perform(Operation.add);
		verifyNoMoreInteractions(calcMock);	
	}

	@Test
	public void validCalculation02() throws Exception {

		Calculator calcMock = mock(Calculator.class);

		
		when(calcMock.pop()).thenReturn(3.0);
		when(calcMock.perform(Operation.add)).thenReturn(3.0);

		Parser p = new Parser(calcMock);
		double result = p.parse(new File("test/resources/test02.xml"));
		assertEquals(3.0, result, 0);
		
		verify(calcMock).pop();
		
		verify(calcMock).push(1);
		verify(calcMock).push(2);
		verify(calcMock).push(3);

	}

	@Test
	public void validCalculation03() throws Exception {

		Calculator calcMock = mock(Calculator.class);
		calcMock.push(1);
		calcMock.push(2);
		when(calcMock.perform(Operation.add)).thenReturn(3.0);
		calcMock.push(3);
		calcMock.push(2);
		when(calcMock.perform(Operation.mul)).thenReturn(6.0);

		Parser p = new Parser(calcMock);
		double result = p.parse(new File("test/resources/test03.xml"));
		assertEquals(6.0, result, 0);

		validateMockitoUsage();
	}

}
