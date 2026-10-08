    static String bestVideoUrlFromMedia(Object media) {
        List<String> all = new ArrayList<>();
        collectVideoUrlsFromDictionary(media, all);
        if (all.isEmpty()) {
            Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<>());
            collectAllVideoUrls(media, all, visited, 0);
        }
        if (all.isEmpty()) return null;

        for (String u : all) {
            if (u.contains("/m86/") || u.contains("%2Fm86%2F")) {
                return cleanVideoUrl(u);
            }
        }
        return cleanVideoUrl(all.get(0));
    }
