  @Data
  public class FeeKeyVo extends FeeKey {
  
      @Schema(description = "Miscellaneous fee value list")
      private List<FeeValue> feeValueList;
  }