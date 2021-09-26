package banner;

import java.util.Arrays;

/**
 * En klass för att översätta en sträng till en rad Array7x7-objekt
 * @author Haris
 */
public class Characters {

	/**
	 * En metod för att översätta en sträng till Array7x7-objekt,
	 * i förvalda färger, vit text och svart bakgrund
	 * @param input Strängen som skall översättas
	 * @return Array7x7-array med bokstäverna
	 */
	public static Array7x7[][] translate(String input) {
		return  translate(input, Color.WHITE, Color.BLACK);
	}

	/**
	 * En metod för att översätta en sträng till Array7x7-objekt,
	 * med val för färger
	 * @param input Strängen som skall översättas
	 * @return Array7x7-array med bokstäverna
	 */
	public static Array7x7[][] translate(String input, int fore, int back) {
		Array7x7[][] res = new Array7x7[1][input.length()];
		input = input.toLowerCase();
		for (int i = 0; i < input.length(); i++) {
			res[0][i] = translate(input.charAt(i), fore, back);
		}
		return res;
	}

	/**
	 * En metod för att översätta ett tecken till ett Array7x7-objekt,
	 * i förvalda färger, vit text och svart bakgrund
	 * @param input Tecknet som skall översättas
	 * @return Array7x7-objekt med bokstäverna
	 */
	public static Array7x7 translate(char input) {
		return translate(input, Color.WHITE, Color.BLACK); 
	}

	/**
	 * En metod för att översätta ett tecken till ett Array7x7-objekt,
	 * med val för färger
	 * @param input Tecknet som skall översättas
	 * @return Array7x7-objekt med bokstäverna
	 */
	public static Array7x7 translate(char input, int back, int fore) {
		Array7x7 res = space();
		switch (input) {
		case ' ':
			res = space(back, fore);
			break;
		case '0':
			res = zero(back, fore);
			break;
		case '1':
			res = one(back, fore);
			break;
		case '2':
			res = two(back, fore);
			break;
		case '3':
			res = three(back, fore);
			break;
		case '4':
			res = four(back, fore);
			break;
		case '5':
			res = five(back, fore);
			break;
		case '6':
			res = six(back, fore);
			break;
		case '7':
			res = seven(back, fore);
			break;
		case '8':
			res = eight(back, fore);
			break;
		case '9':
			res = nine(back, fore);
			break;
		case 'a':
			res = a(back, fore);
			break;
		case 'b':
			res = b(back, fore);
			break;
		case 'c':
			res = c(back, fore);
			break;
		case 'd':
			res = d(back, fore);
			break;
		case 'e':
			res = e(back, fore);
			break;
		case 'f':
			res = f(back, fore);
			break;
		case 'g':
			res = g(back, fore);
			break;
		case 'h':
			res = h(back, fore);
			break;
		case 'i':
			res = i(back, fore);
			break;
		case 'j':
			res = j(back, fore);
			break;
		case 'k':
			res = k(back, fore);
			break;
		case 'l':
			res = l(back, fore);
			break;
		case 'm':
			res = m(back, fore);
			break;
		case 'n':
			res = n(back, fore);
			break;
		case 'o':
			res = o(back, fore);
			break;
		case 'p':
			res = p(back, fore);
			break;
		case 'q':
			res = q(back, fore);
			break;
		case 'r':
			res = r(back, fore);
			break;
		case 's':
			res = s(back, fore);
			break;
		case 't':
			res = t(back, fore);
			break;
		case 'u':
		    res = u(back, fore);
		    break;
		case 'v':
		    res = v(back, fore);
		    break;
		case 'w':
			res = w(back, fore);
			break;
		case 'x':
		    res = x(back, fore);
		    break;
		case 'y':
		    res = y(back, fore);
		    break;
		case 'z':
		    res = z(back, fore);
		    break;
//		case '�':
//		    res = a(back, fore);
//		    break;
//		case '�':
//		    res = a(back, fore);
//		    break;
//		case '�':
//		    res = o(back, fore);
//		    break;
		case '!':
			res = exclamation(back, fore);
			break;
		case '?':
			res = question(back, fore);
			break;
		case '.':
			res = dot(back, fore);
			break;
		case ',':
			res = comma(back, fore);
			break;
		case '#':
			res = hashtag(back, fore);
			break;
		case '+':
			res = plus(back, fore);
			break;
		case '-':
			res = minus(back, fore);
			break;
		case '=':
			res = equals(back, fore);
			break;
		
		default:
			res = notFound(back, fore);
			break;
		}
		return res;
	}

	/**
	 * Returnerar ett space-tecken i form av ett Array7x7-objekt
	 * i förvalda färger, vit text och svart bakgrund
	 * @return Array7x7-objektet
	 */
	public static Array7x7 space() {
		return space(Color.WHITE, Color.BLACK);
	}

	/**
	 * Returnerar ett space-tecken i form av ett Array7x7-objekt
	 * med val av färg
	 * @return Array7x7-objektet
	 */
	public static Array7x7 space(int O, int X) {
		int[][] res = new int[7][7];
		for (int[] row : res) 
			Arrays.fill(row, O);
		return new Array7x7(res);
	}

	public static Array7x7 zero() {
		return zero(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 zero(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, X, X, O},
				{O, X, O, X, O, X, O},
				{O, X, X, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 one() {
		return one(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 one(int O, int X) {
		int[][] res = {
				{O, O, O, X, O, O, O},
				{O, O, X, X, O, O, O},
				{O, X, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 two() {
		return two(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 two(int O, int X) {
		int[][] res = {
				{O, O, X, X, O, O, O},
				{O, X, O, O, X, O, O},
				{O, O, O, O, X, O, O},
				{O, O, O, O, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, O, O, O, O},
				{O, X, X, X, X, X, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 three() {
		return three(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 three(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, O, O, O, O, X, O},
				{O, O, X, X, X, X, O},
				{O, O, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 four() {
		return four(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 four(int O, int X) {
		int[][] res = {
				{O, O, O, O, X, O, O},
				{O, O, O, X, X, O, O},
				{O, O, X, O, X, O, O},
				{O, X, X, X, X, X, O},
				{O, O, O, O, X, O, O},
				{O, O, O, O, X, O, O},
				{O, O, O, O, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 five() {
		return five(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 five(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, O, O},
				{O, X, X, X, X, O, O},
				{O, O, O, O, O, X, O},
				{O, O, O, O, O, X, O},
				{O, X, O, O, X, O, O},
				{O, O, X, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 six() {
		return six(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 six(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, O, O},
				{O, X, O, O, O, O, O},
				{O, X, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 seven() {
		return seven(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 seven(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, O, O, O, O, X, O},
				{O, O, O, O, X, O, O},
				{O, O, O, X, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 eight() {
		return eight(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 eight(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 nine() {
		return nine(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 nine(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, X, O},
				{O, O, O, O, O, X, O},
				{O, O, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 a() {
		return a(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 a(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 b() {
		return b(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 b(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 c() {
		return c(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 c(int O, int X) {
		int[][] res = {
				{O, O, O, X, X, X, O},
				{O, O, X, O, O, X, O},
				{O, X, O, O, O, O, O},
				{O, X, O, O, O, O, O},
				{O, X, O, O, O, O, O},
				{O, O, X, O, O, X, O},
				{O, O, O, X, X, X, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 d() {
		return d(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 d(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 e() {
		return e(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 e(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 f() {
		return f(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 f(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, X, X, X, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 g() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 g(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, O, O},
				{O, X, O, X, X, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 h() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 h(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 i() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 i(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 j() {
		return j(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 j(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, X, O},
				{O, O, O, O, X, O, O},
				{O, O, O, O, X, O, O},
				{O, O, O, O, X, O, O},
				{O, X, O, O, X, O, O},
				{O, O, X, O, X, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 k() {
		return k(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 k(int O, int X) {
		int[][] res = {
				{O, X, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, X, O, O},
				{O, O, X, X, O, O, O},
				{O, O, X, O, X, O, O},
				{O, O, X, O, O, X, O},
				{O, X, X, O, O, X, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 l() {
		return l(Color.WHITE, Color.BLACK);
	}
	
	public static Array7x7 l(int O, int X) {
		int[][] res = {
				{O, X, X, X, O, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, X, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 m() {
		return m(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 m(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, X, O, X, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 n() {
		return n(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 n(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, X, O, O, X, O},
				{O, X, X, O, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, X, X, X, O},
				{O, X, O, O, X, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 o() {
		return o(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 o(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 p() {
		return p(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 p(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, X, X, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 q() {
		return q(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 q(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, X, O, O},
				{O, O, X, X, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 r() {
		return r(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 r(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, O, X, X, O, O, O},
				{O, O, X, O, X, O, O},
				{O, X, X, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 s() {
		return s(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 s(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, O, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 t() {
		return t(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 t(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, X, O, X, O, X, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 u() {
		return u(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 u(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 v() {
		return v(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 v(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, O, X, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 w() {
		return w(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 w(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, X, O, X, O},
				{O, O, X, O, X, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 x() {
		return x(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 x(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, O, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, O, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 y() {
		return y(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 y(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, O, X, O, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 z() {
		return z(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 z(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, O, O, O, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, O, O, O, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 å() {
		return å(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 å(int O, int X) {
		int[][] res = {
				{O, O, O, X, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 ä() {
		return ä(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 ä(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, O, O, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}
	
//	public static Array7x7 a() {
//		return a(Color.WHITE, Color.BLACK);
//	}
//
//	public static Array7x7 a(int O, int X) {
//		int[][] res = {
//				{O, X, O, O, O, X, O},
//				{O, O, O, O, O, O, O},
//				{O, O, X, X, X, O, O},
//				{O, X, O, O, O, X, O},
//				{O, X, O, O, O, X, O},
//				{O, X, O, O, O, X, O},
//				{O, O, X, X, X, O, O}};
//		return new Array7x7(res);
//	}
	
	public static Array7x7 exclamation() {
		return exclamation(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 exclamation(int O, int X) {
		int[][] res = {
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 question() {
		return question(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 question(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, O, X, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 dot() {
		return dot(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 dot(int O, int X) {
		int[][] res = {
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, X, X, O, O, O, O},
				{O, X, X, O, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 comma() {
		return comma(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 comma(int O, int X) {
		int[][] res = {
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, X, X, O, O, O, O},
				{O, X, X, O, O, O, O},
				{O, O, X, O, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 hastag() {
		return hashtag(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 hashtag(int O, int X) {
		int[][] res = {
				{O, O, O, O, O, O, O},
				{O, O, X, O, X, O, O},
				{O, X, X, X, X, X, O},
				{O, O, X, O, X, O, O},
				{O, X, X, X, X, X, O},
				{O, O, X, O, X, O, O},
				{O, O, O, O, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 plus() {
		return plus(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 plus(int O, int X) {
		int[][] res = {
				{O, O, O, O, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, X, X, X, X, X, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, O, O, O, O}};
		return new Array7x7(res);
	}
	
	public static Array7x7 minus() {
		return minus(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 minus(int O, int X) {
		int[][] res = {
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, X, X, X, X, X, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O}};
		return new Array7x7(res);
	}	
	
	
	public static Array7x7 equals() {
		return equals(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 equals(int O, int X) {
		int[][] res = {
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O},
				{O, X, X, X, X, X, O},
				{O, O, O, O, O, O, O},
				{O, X, X, X, X, X, O},
				{O, O, O, O, O, O, O},
				{O, O, O, O, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 notFound() {
		return t(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 notFound(int O, int X) {
		int[][] res = new int[7][7];
		for (int[] row : res) 
			Arrays.fill(row, X);
		return new Array7x7(res);
}
}
