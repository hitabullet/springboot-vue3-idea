package com.end.project.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;


public class CommonUtil
{


	private CommonUtil()
	{

	}

	public static String getUUID()
	{
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}


	public static long getCurrTimeStamp()
	{
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = dateTime.atZone(zoneId);
		return zonedDateTime.toEpochSecond();
	}

}