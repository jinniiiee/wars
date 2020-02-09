package com.isha.prepare;

import java.util.Set;

public class DiskSpace {
    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        if(blockSize < 1 || blockSize > 1000000 || fileSize < 1 || fileSize > blockSize || fileSize + occupiedSectors.size() > blockSize){
            return false;
        }
        if(fileSize == 1 && blockSize - occupiedSectors.size() >= 1){
            return true;
        }
        for(Integer occupiedSector : occupiedSectors){
            if(hasPreviousSlots(fileSize, occupiedSectors, occupiedSector)) {
                return true;
            }else if(hasNextSlots(fileSize, occupiedSectors, occupiedSector, blockSize)){
                return true;
            }
        }
        return false;
    }

    private static boolean hasNextSlots(int fileSize, Set<Integer> occupiedSectors, Integer occupiedSector, int blockSize) {
        for(int checkSlot = occupiedSector+1; checkSlot <= occupiedSector+fileSize; checkSlot++){
            if(occupiedSectors.contains(checkSlot) || checkSlot > blockSize){
                break;
            }
            if(checkSlot == occupiedSector+fileSize){
                return true;
            }
        }
        return false;
    }

    private static boolean hasPreviousSlots(int fileSize, Set<Integer> occupiedSectors, Integer occupiedSector) {
        for(int checkSlot = occupiedSector-1; checkSlot >= occupiedSector-fileSize; checkSlot--){
            if(occupiedSectors.contains(checkSlot) || checkSlot <= 0){
                break;
            }
            if(checkSlot == occupiedSector-fileSize){
                return true;
            }
        }
        return false;
    }
}

