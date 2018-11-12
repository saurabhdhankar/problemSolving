class CityTourWithGasStation {
	
	static class GasStation {
		int gas;
		int distance;

		public GasStation(int g, int d) {
			this.gas = g;
			this.distance = d;
		}
	}

	static int printTour(GasStation [] arr, int n) {
		int start = 0;
		int end = 1;
		int currGas = arr[start].gas - arr[start].distance;
		
		while(end != start || currGas < 0) {
			
			while(currGas < 0 && start != end) {
				currGas -= arr[start].gas - arr[start].distance;

				start = (start+1)%n;

				if(start == 0) {
					return -1;
				}
			}
			currGas += arr[end].gas - arr[end].distance;

			end = (end+1)%n;
		}
		return start;
	}

	public static void main(String[] args) {
		GasStation[] arr = {new GasStation(6, 4),
					new GasStation(3, 6),
					new GasStation(7, 3)};

		int start = printTour(arr, arr.length);

		if(start == -1){
			System.out.println("No Solution exists");
		} else {
			System.out.println("Tour Starting point is: "+start);
		}
		return;
	}

}
