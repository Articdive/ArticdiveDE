rootProject.name = "ArticdiveDE"

include("frontend")
include("backend")

include("backend:core")
findProject(":backend:core")?.name = "core"

include("backend:rcg")
findProject(":backend:rcg")?.name = "rcg"

include("backend:ccc")
findProject(":backend:ccc")?.name = "ccc"