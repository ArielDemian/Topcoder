import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PaperAndPaintTest {
	private PaperAndPaint pp;

	@Before
	public void setUp() throws Exception {
		pp = new PaperAndPaint();
	}

	@Test
	public void test0() {
		int width = 5;
		int height = 6;
		int[] xfold = { 2 };
		int[] cnt = { 2 };
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		int[] x2 = { 3 };
		int[] y2 = { 2 };
		long expected = 21;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test1() {
		int width = 2;
		int height = 4;
		int[] xfold = { 0, 0 };
		int[] cnt = { 1, 0 };
		int[] x1 = { 0, 0 };
		int[] y1 = { 1, 1 };
		int[] x2 = { 2, 1 };
		int[] y2 = { 2, 4 };
		long expected = 3;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test2() {
		int width = 5;
		int height = 6;
		int[] xfold = { 2 };
		int[] cnt = { 2 };
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		int[] x2 = { 3 };
		int[] y2 = { 2 };
		long expected = 21;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test3() {
		int width = 5;
		int height = 6;
		int[] xfold = { 2 };
		int[] cnt = { 2 };
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		int[] x2 = { 3 };
		int[] y2 = { 2 };
		long expected = 21;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test4() {
		int width = 5;
		int height = 6;
		int[] xfold = { 2 };
		int[] cnt = { 2 };
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		int[] x2 = { 3 };
		int[] y2 = { 2 };
		long expected = 21;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test5() {
		int width = 5;
		int height = 6;
		int[] xfold = { 2 };
		int[] cnt = { 2 };
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		int[] x2 = { 3 };
		int[] y2 = { 2 };
		long expected = 21;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test6() {
		int width = 17;
		int height = 3;
		int[] xfold = { 17, 2, 10, 2, 10, 13 };
		int[] cnt = { 2, 0, 0, 2, 0, 0 };
		int[] x1 = { 7, 6, 4, 11, 0, 5 };
		int[] y1 = { 0, 0, 1, 0, 1, 1 };
		int[] x2 = { 12, 10, 6, 12, 4, 12 };
		int[] y2 = { 1, 3, 2, 1, 2, 2 };
		long expected = 20;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}

	@Test
	public void test7() {
		int width = 787349513;
		int height = 595350000;
		int[] xfold = { 296528168, 195813523, 206399066, 571988347, 639128268, 289447332, 665631868, 611903311, 273395283, 611436620, 40280637, 770299178, 400220974, 285686914, 617006021, 613993497, 559626407, 720468883, 445536499, 101683051, 572026006, 784246942, 86428222, 452852876, 433738374, 234835122, 718855678, 52608851, 5188027, 556768160, 673689527, 668813224, 689271580, 72526717, 429701637, 649441597, 66243213, 123800296, 346680923, 667565574, 590656572, 314099447, 744284002, 96842505 };
		int[] cnt = { 419, 269, 134, 47, 179, 299, 99, 249, 79, 5, 27, 944, 23, 19, 242, 377, 74, 839, 1, 249, 899, 224, 55, 215, 8, 566, 14, 699, 629, 79, 2, 839, 335, 3, 41, 19, 35, 23, 524, 15, 83, 13, 8, 809 };
		int[] x1 = { 50551569, 141722143, 33589946, 167646510, 9320411, 24604959, 50218792, 97515143, 86127166, 80852886, 9784471, 212966695, 24720179, 452896054, 105676313, 28720505, 13050219, 58706787, 182463063, 142513635, 34089391, 668462400, 5146104, 250747252, 12969982, 154497750, 90499848, 45831443, 34225473, 33728282, 376100272, 66062274, 8473420, 85356643, 48103652, 385514830, 8241717, 251104416, 81941260, 237453403, 257568378, 182561772, 479324394, 325929459 };
		int[] y1 = { 151217, 1146580, 463200, 1413815, 87405, 19030, 756338, 97356, 2345253, 182599, 1505304, 116978, 2182199, 5588580, 557895, 293007, 806401, 171398, 148067684, 57186, 31755, 1812904, 8456, 726512, 49392607, 199954, 11697936, 263804, 97850, 2589497, 1735157, 483588, 733760, 71244604, 3930627, 6654506, 40097, 11509708, 526771, 2625496, 1283220, 27572741, 1213079, 155369 };
		int[] x2 = { 365785082, 348972172, 44614362, 502475445, 35471640, 27712723, 107695123, 165856356, 494920150, 191202078, 84461056, 547602152, 75715436, 473265300, 268753909, 38812296, 26499540, 213462803, 229474272, 559172260, 95572753, 693508095, 18800201, 388686533, 64709137, 163516148, 544256664, 478007936, 281981508, 179567521, 656412947, 157168428, 72381377, 389366011, 402759418, 467487424, 81115694, 266854684, 231035923, 324314180, 342666953, 350086559, 511893924, 647752302 };
		int[] y2 = { 578904, 1938334, 1482131, 7545133, 128506, 43615, 4132575, 153206, 2504743, 2711315, 3779767, 129217, 9564983, 6801945, 2223606, 568805, 3512610, 444763, 196280046, 65696, 74200, 2524648, 4733941, 1534772, 59240685, 269501, 23464338, 682579, 113723, 4177499, 22439659, 634914, 765192, 84863689, 10308080, 15095198, 1719460, 19627843, 584462, 21274031, 3157213, 29389177, 21020119, 683242 };
		long expected = 22203030005996653L;
		assertEquals(expected, pp.computeArea(width, height, xfold, cnt, x1, y1, x2, y2));
	}
}