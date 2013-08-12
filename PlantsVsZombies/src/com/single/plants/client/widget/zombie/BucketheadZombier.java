package com.single.plants.client.widget.zombie;

import com.framework.client.event.Listener;
import com.framework.client.util.Rectangle;
import com.single.plants.client.event.PVZEvent;
import com.single.plants.client.event.ZombieEvent;
import com.single.plants.client.model.zombie.Zombie;
import com.single.plants.client.widget.Zombier;

public class BucketheadZombier extends Zombier {

	public BucketheadZombier(Zombie zombie) {
		super(zombie, zombiesResource.bucketheadZombie());
		
		addListener(PVZEvent.UpdateZombieStatus, new Listener<ZombieEvent>() {
			public void handleEvent(ZombieEvent be) {
				switch (be.getStatus()) {
				case Forward:
					img.setSrc(zombiesResource.bucketheadZombie().getURL());
					break;
				case Attack:
					img.setSrc(zombiesResource.bucketheadZombieAttack().getURL());
				default:
					break;
				}
			}
		});
	}

	@Override
	public Rectangle attactBody() {
		Rectangle r=el().getBounds(true);
		r.width=1;
		r.y+=r.height/4;
		r.height/=2;
		r.x+=25;
		
		return r;
	}

	@Override
	public Rectangle defenseBody() {
		Rectangle r=el().getBounds(true);
		r.x+=r.width/2;
		r.y+=r.height/2;
		r.width/=2;
		r.height/=2;
		return r;
	}
}
