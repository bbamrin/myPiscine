package edu.school21.printer.app;
import edu.school21.printer.logic.*;
import com.beust.jcommander.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import edu.school21.printer.logic.ImageService;


public class PermittedColor implements IParameterValidator {
	public void validate(String name, String value) throws ParameterException {
		Boolean isValid = false;
		for (ImageService.Colors color : ImageService.Colors.values()) {
			if (color.toString().equals(value))
				isValid = true;
		}
		if (!isValid){
			throw new ParameterException(
					"Parameter " + name + " should be [RED | GREEN | BLUE | CYAN | YELLOW | BLACK | WHITE | MAGENTA] (found " + value +")"
			);
		}
	}
}
