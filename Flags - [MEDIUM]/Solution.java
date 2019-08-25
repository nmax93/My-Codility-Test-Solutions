import java.lang.Math;

class Solution {
    public int solution(int[] A) {
        
        if (A.length < 3) return 0;
        
        int[] peeks = new int[A.length];
        int firstPeek = -1, lastPeek = -1, numberOfPeeks = 0, firstLastPeeksDistance;
        int rootFloor, maxNumberOfFlags, flags, lastVisitedPeek, distanceFromLastVisitedPeek;
        int curNumOfFlags, bestSoFarNumOfFlags = 0;
        
        for(int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                if (firstPeek == -1) {
                    firstPeek = lastPeek = i;
                } else {
                    lastPeek = i;
                }
                peeks[i]++;
                numberOfPeeks++;
                i++;
            }
        }
        
        if (numberOfPeeks < 3) return numberOfPeeks;
        
        firstLastPeeksDistance = lastPeek - firstPeek + 1;
        rootFloor = (int)Math.sqrt(firstLastPeeksDistance);
        
        if (rootFloor * (rootFloor + 1) < firstLastPeeksDistance) {
            maxNumberOfFlags = rootFloor + 1;
        } else {
            maxNumberOfFlags = rootFloor;
        }
        
        if (numberOfPeeks < maxNumberOfFlags) maxNumberOfFlags = numberOfPeeks;
        
        for(int i = 2; i <= maxNumberOfFlags; i++) {
            lastVisitedPeek = firstPeek;
            curNumOfFlags = 1;
            distanceFromLastVisitedPeek = i - 1;
            for(int j = firstPeek + i; j < peeks.length - 1; j++) {
                distanceFromLastVisitedPeek++;
                if (peeks[j] == 1 && distanceFromLastVisitedPeek >= i) {
                    curNumOfFlags++;
                    distanceFromLastVisitedPeek = i - 1;
                    j += i - 1;
                }
                if (curNumOfFlags == i) break;
            }
            if (curNumOfFlags > bestSoFarNumOfFlags) {
                bestSoFarNumOfFlags = curNumOfFlags;
            }
        }
        
        return bestSoFarNumOfFlags;
    }
}
