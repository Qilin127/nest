package com.nest.renting.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nest.renting.model.entity.CityInfo;

/**
 * CityInfoService
 *
 * Service interface for performing database operations on the {@code city_info} table.
 * This interface extends MyBatis-Plus {@link IService} to provide common CRUD methods,
 * and can be further extended with custom business logic for handling city-related data.
 *
 * Typical use cases:
 * <ul>
 *     <li>Retrieve city information by province</li>
 *     <li>Manage city records (add, update, delete)</li>
 *     <li>Support queries for region selection in the rental application</li>
 * </ul>
 *
 * @author Yuze Wang
 * @since 2025-08-24
 */
public interface CityInfoService extends IService<CityInfo> {
    // Additional custom methods for city management can be declared here if needed
}