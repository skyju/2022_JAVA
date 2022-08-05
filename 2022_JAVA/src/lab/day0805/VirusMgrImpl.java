package com.ssafy.corona.virus;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;

	public VirusMgrImpl() {
		virus = new Virus[100];
	}

	@Override
	public void add(Virus v) throws DuplicatedException {
		try {
			// 4. 이미 등록된 경우인 경우
			if (search(v.getName()) != null)
				throw new DuplicatedException(v.getName() + ": 등록된 바이러스입니다.");
		} catch (NotFoundException e) {
			virus[index++] = v;
		}
	}

	@Override
	public Virus[] search() {
		// 3. index만큼
		// return virus;
		
		Virus[] ans = new Virus[index];
		System.arraycopy(virus, 0, ans, 0, index);
		return ans;
	}

	@Override
	public Virus search(String name) throws NotFoundException {
		// 2. index만큼
		// for(int i=0; i<virus.length; i++) {
		for (int i = 0; i < index; i++) {
			if (virus[i].getName().equals(name)) {
				return virus[i];
			}
		}
		throw new NotFoundException(name + ": 미등록 바이러스입니다.");
	}
}
