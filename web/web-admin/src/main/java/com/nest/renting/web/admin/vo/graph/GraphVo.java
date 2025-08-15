package com.nest.renting.web.admin.vo.graph;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the image information. This class encapsulates the basic details of an image,
 * including its name and URL. It is designed to be used as a value object for transferring
 * image - related data in the application.
 */
@Data
@Schema(description = "Image Information")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GraphVo {

    /**
     * The name of the image. This could be a descriptive name for the image,
     * which can be used for identification and display purposes.
     */
    @Schema(description = "Image name")
    private String name;

    /**
     * The URL of the image. This is the web address where the image can be accessed.
     */
    @Schema(description = "Image URL")
    private String url;

}
