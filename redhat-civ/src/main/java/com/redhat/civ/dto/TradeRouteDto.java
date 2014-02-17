package com.redhat.civ.dto;

import java.util.List;

public class TradeRouteDto {

	public long id;
	public CityDto from;
	public CityDto to;
	public List<TileDto> tiles;
}
