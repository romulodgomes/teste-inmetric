package br.com.inmetrics.teste.support;

import java.util.Calendar;
import java.util.Date;

public class GetTimeExecution {
	private static Calendar horarioExecucao = Calendar.getInstance();
	
	public static Date getTime() {
		return horarioExecucao.getTime();
	}
}
