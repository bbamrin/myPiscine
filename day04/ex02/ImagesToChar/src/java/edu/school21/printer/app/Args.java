package edu.school21.printer.app;
import edu.school21.printer.logic.*;
import com.beust.jcommander.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;



@Parameters(separators = "=")
public class Args {

	@Parameter
	private List<String> parameters = new ArrayList<>();

	@Parameter(names = {"--white", "-w"}, description = "White color", required = true, validateWith = PermittedColor.class)
	private String white;

	@Parameter(names = {"--black", "-b"}, description = "Black color", required = true, validateWith = PermittedColor.class)
	private String black;

	public String getWhite() {
		return white;
	}

	public void setWhite(String white) {
		this.white = white;
	}

	public String getBlack() {
		return black;
	}

	public void setBlack(String black) {
		this.black = black;
	}
}

