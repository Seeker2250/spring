package org.doit.ik.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SalgradeDTO {
	private int grade;
	private int losal;
	private int hisal;
}
