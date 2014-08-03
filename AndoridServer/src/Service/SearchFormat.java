package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Domain.Arg;
import Domain.Token;

/**
 * 
 * @author Lixu
 *
 */
public class SearchFormat {
	private List<String> nes = new ArrayList<String>();
	private List<String> alt = new ArrayList<String>();

	public String getSearchSent(String sen) throws IOException {
		sen = sen.replaceAll(" ", ",");
		// System.out.println(sen);
		// split the sentence
		SplitService splits = new SplitService();
		List<Token> tokens = splits.split(sen);

		for (int i = 0; i < tokens.size(); i++) {
			System.out.println(tokens.get(i));
		}
		Boolean found = false;

		// get
		// ===============================================================
		if (sen.contains("Â¡Â°")) {
			int beg = sen.indexOf("Â¡Â°");
			int end = sen.indexOf("Â¡Â±", beg);
			nes.add(sen.substring(beg + 1, end));
			found = true;
		}
		
		if (sen.contains("\"")) {
			int beg = sen.indexOf("\"");
			int end = sen.indexOf("\"", beg);
			nes.add(sen.substring(beg + 1, end));
			found = true;
		}

		if (sen.contains("¡°")) {
			int beg = sen.indexOf("¡°");
			int end = sen.indexOf("¡±", beg);
			nes.add(sen.substring(beg + 1, end));
			found = true;
		}

		if (sen.contains("¡¶")) {
			int beg = sen.indexOf("¡¶");
			int end = sen.indexOf("¡·", beg);
			nes.add(sen.substring(beg + 1, end));
			found = true;
		}

		// get name
		// ===============================================================
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getNe().equals("S-Nh")) {
				String cur = tokens.get(i).getCont();
				if (cur.length() <= 1)
					continue;
				if (tokens.get(i).getRelate().equals("ATT")) {
					if (i + 1 < tokens.size())
						cur += tokens.get(i + 1).getCont();
				}
				if (found) {
					alt.add(cur);
				} else {
					found = true;
					nes.add(cur);
				}
			}
		}

		// get A0
		// =======================================================================
		List<Integer> used = new ArrayList<Integer>();
		if (!found) {
			List<String> a0list = new ArrayList<String>();
			for (int i = 0; i < tokens.size(); i++) {
				List<Arg> args = tokens.get(i).getArg();
				if (args.size() == 0)
					continue;
				for (int j = 0; j < args.size(); j++) {
					Arg cur = args.get(j);
					if (cur.getType().equals("A0")) {
						int beg = cur.getBeg();
						int end = cur.getEnd();
						String a0 = "";
						for (int t = beg; t <= end; t++) {
							a0 += tokens.get(t).getCont();
						}
						if (a0.length() > 1 && a0.length() < 8) {
							a0list.add(a0);
							for (int t = beg; t <= end; t++) {
								used.add(t);
							}
						}
					}
				}
			}
			if (a0list.size() != 0) {
				String mini = a0list.get(0);
				for (int i = 0; i < a0list.size(); i++) {
					if (a0list.get(i).length() < mini.length())
						mini = a0list.get(i);
				}

				if (found)
					alt.add(mini);
				else {
					nes.add(mini);
					found = true;
				}

				System.out.println(mini);
			}
		}
		// get ATT
		// ================================================================================
		List<String> attlist = new ArrayList<String>();

		for (int i = 0; i < tokens.size(); i++) {
			boolean inUsed = false;
			for (int j = 0; j < used.size(); j++) {
				if (used.get(j) == i) {
					inUsed = true;
					break;
				}
			}
			if (inUsed)
				continue;

			String att = "";
			Token t = tokens.get(i);
			if (t.getRelate().equals("ATT")) {
				att += t.getCont();
				while (t.getRelate().equals("ATT")) {
					int parent = t.getParent();
					if (parent - t.getId() > 1 || parent - t.getId() < -1)
						break;
					t = tokens.get(parent);
					att += tokens.get(parent).getCont();
					used.add(parent);
				}
				attlist.add(att);
			}
		}
		if (attlist.size() != 0) {
			for (int i = 0; i < attlist.size(); i++) {
				if (attlist.get(i).length() <= 1)
					continue;
				alt.add(attlist.get(i));
				System.out.println(attlist.get(i));
			}
		}

		// format search context
		// ==================================================================
		if (alt.size() == 0 && nes.size() == 0)
			return sen;
		if (nes.size() == 0) {
			nes.add(alt.get(0));
			alt.remove(0);
		}
		if (alt.size() <= 1) {
			for (int i = 0; i < alt.size(); i++) {
				nes.add(alt.get(0));
				alt.remove(0);
			}
		}

		System.out.println(alt.size());
		String ss = "";
		for (int i = 0; i < nes.size(); i++) {

			ss += nes.get(i);
			ss += " ";
		}
		if (alt.size() != 0) {
			ss += "(";
			for (int i = 0; i < alt.size(); i++) {

				ss += alt.get(i);
				if (i == alt.size() - 1)
					break;
				ss += " | ";
			}
			ss += ")";
		}
		return ss;
	}
}
