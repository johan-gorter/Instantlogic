package org.instantlogic.example.izzy.deduction;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class CutOffTextDeduction extends Deduction<String> {

  private Deduction<String> text;

  public void setText(Deduction<String> text) {
    this.text = text;
  }

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		ValueAndLevel<String> source = text.deduce(context);
		if (source.getValue() == null) {
		  return source;
		}
		if (source.getValue().length()<30) {
		  return source;
		}
		return ValueAndLevel.rule(source.getValue().substring(0, 27)+ "...");
	}
}
