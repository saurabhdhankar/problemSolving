class IncreaseDecreaseSequence{
	public static void main(String[] args){
		printMinNumberForPattern("IDID");
		printMinNumberForPattern("I");
		printMinNumberForPattern("DD");
		printMinNumberForPattern("II");
		printMinNumberForPattern("DIDI");
	        printMinNumberForPattern("IIDDD");
		printMinNumberForPattern("DDIDDIID");
	}

	static void printMinNumberForPattern(String ptrn) {
		int cur_max = 0;
		int last_entry = 0;

		int j;

		for(int i = 0; i < ptrn.length(); i++) {
		
			int noOfNextD = 0;
			switch(ptrn.charAt(i)) {
				case 'I':
					j = i+1;
					while(j < ptrn.length() && ptrn.charAt(j) == 'D') {
						noOfNextD++;
						j++;
					}
					
					if(i == 0) {
						cur_max = noOfNextD + 2;
						last_entry++;
						System.out.print(" "+last_entry);
						System.out.print(" "+cur_max);

						last_entry = cur_max;
					} else {
						cur_max = cur_max + noOfNextD + 1;

						last_entry = cur_max;
						System.out.print(" "+last_entry);
					}

					for(int k = 0; k < noOfNextD ; k++ ) {
						System.out.print(" "+ (--last_entry));
						i++;
					}
					break;
				case 'D':
					if(i == 0) {
						j = i+1;
						while(j < ptrn.length() && ptrn.charAt(j) == 'D') {
							noOfNextD++;
							j++;
						}

						cur_max = noOfNextD + 2;
						System.out.print(" "+ cur_max +" "+ (cur_max-1));
						last_entry = cur_max-1;
					} else {
						System.out.print(" "+ (last_entry-1));
						last_entry--;
					}
					break;
			}
		}
		System.out.println();
		return;
	}
}
