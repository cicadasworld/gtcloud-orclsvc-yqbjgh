package gtcloud.specification;

import org.springframework.data.jpa.domain.Specification;

import gtcloud.domain.VCampLocation;

public class VCampLocationSpec {

    public static Specification<VCampLocation> withDkmc(String dkmc) {
        return (root, query, builder) -> builder.like(root.get("dkmc"), "%" + dkmc + "%");
    }

    public static Specification<VCampLocation> withCampWord(String campWord) {
        return (root, query, builder) -> builder.like(root.get("campWord"), "%" + campWord + "%");
    }

    public static Specification<VCampLocation> withCampCode(String campCode) {
        return (root, query, builder) -> builder.like(root.get("campCode"), "%" + campCode + "%");
    }

    public static Specification<VCampLocation> withDetailAddress(String detailAddress) {
        return (root, query, builder) -> builder.like(root.get("detailAddress"), "%" + detailAddress + "%");
    }

    public static Specification<VCampLocation> withBdmc(String bdmc) {
        return (root, query, builder) -> builder.like(root.get("bdmc"), "%" + bdmc + "%");
    }
}
