package model;

public class Piece 
{
	public static final int P_DRAPEAU = 0;
	public static final int P_BOMBE = 1 ;
	public static final int P_ESPION = 2;
	public static final int P_ECLAIREUR =3;
	public static final int P_DEMINEUR= 4;
	public static final int P_SERGENT = 5;
	public static final int P_LIEUTENANT = 6;
	public static final int P_CAPITAINE = 7;
	public static final int P_COMMANDANT = 8;
	public static final int P_COLONEL = 9;
	public static final int P_GENERAL = 10;
	public static final int P_MARECHAL = 11;
	
	public static final int[] I_NB_PIECE = new int[]{
		1,6,1,8,5,4,4,4,3,2,1,1
	};
	
	public static final String[] S_NAME = new String[]{
		"Drapeau","Bombe","Espion","Eclaireur","Demineur",
		"Sergent","Lieutenant","Capitaine","Commandant","Colonel",
		"General","Marechal"
	};
	
	private static final String S_UNKNOWN = "Unknown";

	/**
	 * @return 1 if att beat def, 0 if equal, -1 if att is beaten
	 */
	public static int fight(int att, int def) {
		if(att == P_ESPION && def == P_MARECHAL)
			return 1;
		else if(att != P_DEMINEUR && def == P_BOMBE)
			return -1;
		else if(att == def)
			return 0;
		return (att > def) ? 1 : -1;
	}
	
	public static String getNameFromType(int type){
		return (type < 0 || type > 11) ? S_UNKNOWN : S_NAME[type];
	}
	
	public static int getNumberOfPiece(int type) {
		return (type < 0 || type > 11) ? 0 : I_NB_PIECE[type];
	}
}
