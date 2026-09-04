# Collection choices

| # | Scenario | Need (order / unique / key→value / sorted) | Interface | Implementation | Why |
| - | -------- | ------------------------------------------ | --------- | -------------- | --- |
| 1 | Ordered catalog; duplicate titles allowed | list | `_____` | `_____` | |
| 2 | Unique registered book IDs | set| `_____` | `_____` | |
| 3 | Book ID → current borrower ID | map | `_____` | `_____` | |
| 4 | Alphabetically sorted categories | set| `_____` | `_____` | |
| 5 | Category → count, sorted by category | treemap | `_____` | `_____` | |
| 6 | Checkout history in event order | list | `_____` | `_____` | |







# ask in order
is this a key → value relationship? Choose Map.
Otherwise, must values be unique? Choose Set.
Otherwise, do order/index/duplicates matter? Choose List.
Must iteration be sorted? Consider TreeSet or TreeMap.
Must insertion order be preserved? Consider LinkedHashSet or LinkedHashMap.
