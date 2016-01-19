package com.Zhugesb.algorithms;

public class SearchMaxValueAndMinValue {

	// 分治法
	private static ValueBean Search(int[] arr, int start, int end) {
		if (end - start <= 1) {
			if (arr[start] < arr[end])
				return new ValueBean(arr[end], arr[start]);
			else
				return new ValueBean(arr[start], arr[end]);
		}

		ValueBean valueLeft = Search(arr, start, start + (end - start) / 2);
		ValueBean valueRight = Search(arr, start + (end - start) / 2 + 1, end);

		int maxV = (valueLeft.getMaxV() > valueRight.getMaxV()) ? valueLeft
				.getMaxV() : valueRight.getMaxV();
		int minV = (valueLeft.getMinV() < valueRight.getMinV()) ? valueLeft
				.getMinV() : valueRight.getMinV();
		return new ValueBean(maxV, minV);
	}

	public static void main(String[] args) {
		int[] array = { 5, 6, 8, 3, 7, 9 };
		System.out.println(Search(array, 0, array.length - 1));
	}
}

class ValueBean {

	private int maxV;

	private int minV;

	ValueBean(int maxV, int minV) {
		setMaxV(maxV);
		setMinV(minV);
	}

	public int getMaxV() {
		return maxV;
	}

	public void setMaxV(int maxV) {
		this.maxV = maxV;
	}

	public int getMinV() {
		return minV;
	}

	public void setMinV(int minV) {
		this.minV = minV;
	}

	@Override
	public String toString() {
		return String.format("最大值是:%d,最小值是:%d", getMaxV(), getMinV());
	}
}