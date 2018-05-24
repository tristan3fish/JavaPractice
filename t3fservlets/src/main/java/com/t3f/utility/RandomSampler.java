package com.t3f.utility;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSampler {

    private Random random = new Random();

    public <E> List<E> selectRandomSample(List<E> list, int selectionCount) {
        //https://stackoverflow.com/questions/4702036/take-n-random-elements-from-a-liste
        //https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle

        int length = list.size();

        if (length < selectionCount) {
            throw new IllegalArgumentException("Selection selectionCount is larger than the length of the list");
        }

        for (int i = length - 1; i >= length - selectionCount; --i)
        {
            Collections.swap(list, i , random.nextInt(i + 1));
        }

        return list.subList(length - selectionCount, length);
    }

}
