public class Reversed {
        public int[] reverse(int[] arr){ //creating a reverse array with an array in the parameter
            int[] newArray = new int[arr.length];//we created a new array that takes in the length of the old array
            for (int i = 0; i < arr.length; i++) {//run a loop though the original array length
                newArray[i] =arr[arr.length-(i+1)];//// length - (i + 1) is the n-th to last element so when i = 0, it would be the last element. when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            }return newArray; //you will return newArray
        }

}
